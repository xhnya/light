<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="游戏分数" prop="gameScore">
      <el-input v-model="dataForm.gameScore" placeholder="游戏分数"></el-input>
    </el-form-item>
    <el-form-item label="评分类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="评分类型"></el-input>
    </el-form-item>
    <el-form-item label="评分人" prop="scoreName">
      <el-input v-model="dataForm.scoreName" placeholder="评分人"></el-input>
    </el-form-item>
    <el-form-item label="评分描述" prop="scoreDescribe">
      <el-input v-model="dataForm.scoreDescribe" placeholder="评分描述"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
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
          gameScore: '',
          type: '',
          scoreName: '',
          scoreDescribe: '',
          createTime: '',
          updateTime: '',
          sort: ''
        },
        dataRule: {
          gameScore: [
            { required: true, message: '游戏分数不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '评分类型不能为空', trigger: 'blur' }
          ],
          scoreName: [
            { required: true, message: '评分人不能为空', trigger: 'blur' }
          ],
          scoreDescribe: [
            { required: true, message: '评分描述不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/game/score/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gameScore = data.score.gameScore
                this.dataForm.type = data.score.type
                this.dataForm.scoreName = data.score.scoreName
                this.dataForm.scoreDescribe = data.score.scoreDescribe
                this.dataForm.createTime = data.score.createTime
                this.dataForm.updateTime = data.score.updateTime
                this.dataForm.sort = data.score.sort
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
              url: this.$http.adornUrl(`/game/score/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gameScore': this.dataForm.gameScore,
                'type': this.dataForm.type,
                'scoreName': this.dataForm.scoreName,
                'scoreDescribe': this.dataForm.scoreDescribe,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'sort': this.dataForm.sort
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
