<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="gameId">
      <el-input v-model="dataForm.gameId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bid">
      <el-input v-model="dataForm.bid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="是否佳作" prop="isHot">
      <el-input v-model="dataForm.isHot" placeholder="是否佳作"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          gameId: '',
          bid: '',
          isHot: ''
        },
        dataRule: {
          gameId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isHot: [
            { required: true, message: '是否佳作不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/game/gameproduce/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gameId = data.gameProduce.gameId
                this.dataForm.bid = data.gameProduce.bid
                this.dataForm.isHot = data.gameProduce.isHot
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/game/gameproduce/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gameId': this.dataForm.gameId,
                'bid': this.dataForm.bid,
                'isHot': this.dataForm.isHot
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
