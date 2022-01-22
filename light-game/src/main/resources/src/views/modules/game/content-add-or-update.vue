<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="评论人" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="评论人"></el-input>
    </el-form-item>
    <el-form-item label="评论人" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="评论人"></el-input>
    </el-form-item>
    <el-form-item label="评论头像" prop="cover">
      <el-input v-model="dataForm.cover" placeholder="评论头像"></el-input>
    </el-form-item>
    <el-form-item label="评论内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="评论内容"></el-input>
    </el-form-item>
    <el-form-item label="父评论" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="父评论"></el-input>
    </el-form-item>
    <el-form-item label="游戏id" prop="gameId">
      <el-input v-model="dataForm.gameId" placeholder="游戏id"></el-input>
    </el-form-item>
    <el-form-item label="是否热门，默认为0" prop="isHot">
      <el-input v-model="dataForm.isHot" placeholder="是否热门，默认为0"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
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
          userId: '',
          userName: '',
          cover: '',
          content: '',
          parentId: '',
          gameId: '',
          isHot: '',
          sort: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '评论人不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '评论人不能为空', trigger: 'blur' }
          ],
          cover: [
            { required: true, message: '评论头像不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '评论内容不能为空', trigger: 'blur' }
          ],
          parentId: [
            { required: true, message: '父评论不能为空', trigger: 'blur' }
          ],
          gameId: [
            { required: true, message: '游戏id不能为空', trigger: 'blur' }
          ],
          isHot: [
            { required: true, message: '是否热门，默认为0不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
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
              url: this.$http.adornUrl(`/game/content/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.content.userId
                this.dataForm.userName = data.content.userName
                this.dataForm.cover = data.content.cover
                this.dataForm.content = data.content.content
                this.dataForm.parentId = data.content.parentId
                this.dataForm.gameId = data.content.gameId
                this.dataForm.isHot = data.content.isHot
                this.dataForm.sort = data.content.sort
                this.dataForm.createTime = data.content.createTime
                this.dataForm.updateTime = data.content.updateTime
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
              url: this.$http.adornUrl(`/game/content/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'userName': this.dataForm.userName,
                'cover': this.dataForm.cover,
                'content': this.dataForm.content,
                'parentId': this.dataForm.parentId,
                'gameId': this.dataForm.gameId,
                'isHot': this.dataForm.isHot,
                'sort': this.dataForm.sort,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
