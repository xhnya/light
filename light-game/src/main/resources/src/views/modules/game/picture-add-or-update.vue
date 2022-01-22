<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="图片链接" prop="coverUrl">
      <el-input v-model="dataForm.coverUrl" placeholder="图片链接"></el-input>
    </el-form-item>
    <el-form-item label="图集id" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="图集id"></el-input>
    </el-form-item>
    <el-form-item label="是否在首页显示" prop="isShow">
      <el-input v-model="dataForm.isShow" placeholder="是否在首页显示"></el-input>
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
          coverUrl: '',
          parentId: '',
          isShow: '',
          sort: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          coverUrl: [
            { required: true, message: '图片链接不能为空', trigger: 'blur' }
          ],
          parentId: [
            { required: true, message: '图集id不能为空', trigger: 'blur' }
          ],
          isShow: [
            { required: true, message: '是否在首页显示不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/game/picture/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.coverUrl = data.picture.coverUrl
                this.dataForm.parentId = data.picture.parentId
                this.dataForm.isShow = data.picture.isShow
                this.dataForm.sort = data.picture.sort
                this.dataForm.createTime = data.picture.createTime
                this.dataForm.updateTime = data.picture.updateTime
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
              url: this.$http.adornUrl(`/game/picture/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'coverUrl': this.dataForm.coverUrl,
                'parentId': this.dataForm.parentId,
                'isShow': this.dataForm.isShow,
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
