<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="gameId">
      <el-input v-model="dataForm.gameId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="年份" prop="year">
      <el-input v-model="dataForm.year" placeholder="年份"></el-input>
    </el-form-item>
    <el-form-item label="发奖机构" prop="institutionsName">
      <el-input v-model="dataForm.institutionsName" placeholder="发奖机构"></el-input>
    </el-form-item>
    <el-form-item label="名称描述" prop="nameDescribe">
      <el-input v-model="dataForm.nameDescribe" placeholder="名称描述"></el-input>
    </el-form-item>
    <el-form-item label="奖项名称" prop="awardName">
      <el-input v-model="dataForm.awardName" placeholder="奖项名称"></el-input>
    </el-form-item>
    <el-form-item label="" prop="sort">
      <el-input v-model="dataForm.sort" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
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
          year: '',
          institutionsName: '',
          nameDescribe: '',
          awardName: '',
          sort: '',
          createTime: ''
        },
        dataRule: {
          gameId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          year: [
            { required: true, message: '年份不能为空', trigger: 'blur' }
          ],
          institutionsName: [
            { required: true, message: '发奖机构不能为空', trigger: 'blur' }
          ],
          nameDescribe: [
            { required: true, message: '名称描述不能为空', trigger: 'blur' }
          ],
          awardName: [
            { required: true, message: '奖项名称不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/game/award/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gameId = data.award.gameId
                this.dataForm.year = data.award.year
                this.dataForm.institutionsName = data.award.institutionsName
                this.dataForm.nameDescribe = data.award.nameDescribe
                this.dataForm.awardName = data.award.awardName
                this.dataForm.sort = data.award.sort
                this.dataForm.createTime = data.award.createTime
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
              url: this.$http.adornUrl(`/game/award/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gameId': this.dataForm.gameId,
                'year': this.dataForm.year,
                'institutionsName': this.dataForm.institutionsName,
                'nameDescribe': this.dataForm.nameDescribe,
                'awardName': this.dataForm.awardName,
                'sort': this.dataForm.sort,
                'createTime': this.dataForm.createTime
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
