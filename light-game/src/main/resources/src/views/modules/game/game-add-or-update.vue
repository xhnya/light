<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="游戏名称" prop="gameName">
      <el-input v-model="dataForm.gameName" placeholder="游戏名称"></el-input>
    </el-form-item>
    <el-form-item label="官网链接" prop="website">
      <el-input v-model="dataForm.website" placeholder="官网链接"></el-input>
    </el-form-item>
    <el-form-item label="封面图" prop="coverUrl">
      <el-input v-model="dataForm.coverUrl" placeholder="封面图"></el-input>
    </el-form-item>
    <el-form-item label="发行时间" prop="releaseTime">
      <el-input v-model="dataForm.releaseTime" placeholder="发行时间"></el-input>
    </el-form-item>
    <el-form-item label="中文名" prop="gameNameChina">
      <el-input v-model="dataForm.gameNameChina" placeholder="中文名"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="gameDescribe">
      <el-input v-model="dataForm.gameDescribe" placeholder="描述"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="游戏类型" prop="gameType">
      <el-input v-model="dataForm.gameType" placeholder="游戏类型"></el-input>
    </el-form-item>
    <el-form-item label="制作商" prop="gameMaking">
      <el-input v-model="dataForm.gameMaking" placeholder="制作商"></el-input>
    </el-form-item>
    <el-form-item label="发行商" prop="gameIssue">
      <el-input v-model="dataForm.gameIssue" placeholder="发行商"></el-input>
    </el-form-item>
    <el-form-item label="详情视频" prop="videoUrl">
      <el-input v-model="dataForm.videoUrl" placeholder="详情视频"></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="是否热门" prop="isHot">
      <el-input v-model="dataForm.isHot" placeholder="是否热门"></el-input>
    </el-form-item>
    <el-form-item label="背景图" prop="bgUrl">
      <el-input v-model="dataForm.bgUrl" placeholder="背景图"></el-input>
    </el-form-item>
    <el-form-item label="主要图片" prop="imgUrl">
      <el-input v-model="dataForm.imgUrl" placeholder="主要图片"></el-input>
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
          gameName: '',
          website: '',
          coverUrl: '',
          releaseTime: '',
          gameNameChina: '',
          gameDescribe: '',
          price: '',
          gameType: '',
          gameMaking: '',
          gameIssue: '',
          videoUrl: '',
          createTime: '',
          updateTime: '',
          isHot: '',
          bgUrl: '',
          imgUrl: '',
          sort: ''
        },
        dataRule: {
          gameName: [
            { required: true, message: '游戏名称不能为空', trigger: 'blur' }
          ],
          website: [
            { required: true, message: '官网链接不能为空', trigger: 'blur' }
          ],
          coverUrl: [
            { required: true, message: '封面图不能为空', trigger: 'blur' }
          ],
          releaseTime: [
            { required: true, message: '发行时间不能为空', trigger: 'blur' }
          ],
          gameNameChina: [
            { required: true, message: '中文名不能为空', trigger: 'blur' }
          ],
          gameDescribe: [
            { required: true, message: '描述不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          gameType: [
            { required: true, message: '游戏类型不能为空', trigger: 'blur' }
          ],
          gameMaking: [
            { required: true, message: '制作商不能为空', trigger: 'blur' }
          ],
          gameIssue: [
            { required: true, message: '发行商不能为空', trigger: 'blur' }
          ],
          videoUrl: [
            { required: true, message: '详情视频不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isHot: [
            { required: true, message: '是否热门不能为空', trigger: 'blur' }
          ],
          bgUrl: [
            { required: true, message: '背景图不能为空', trigger: 'blur' }
          ],
          imgUrl: [
            { required: true, message: '主要图片不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/game/game/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gameName = data.game.gameName
                this.dataForm.website = data.game.website
                this.dataForm.coverUrl = data.game.coverUrl
                this.dataForm.releaseTime = data.game.releaseTime
                this.dataForm.gameNameChina = data.game.gameNameChina
                this.dataForm.gameDescribe = data.game.gameDescribe
                this.dataForm.price = data.game.price
                this.dataForm.gameType = data.game.gameType
                this.dataForm.gameMaking = data.game.gameMaking
                this.dataForm.gameIssue = data.game.gameIssue
                this.dataForm.videoUrl = data.game.videoUrl
                this.dataForm.createTime = data.game.createTime
                this.dataForm.updateTime = data.game.updateTime
                this.dataForm.isHot = data.game.isHot
                this.dataForm.bgUrl = data.game.bgUrl
                this.dataForm.imgUrl = data.game.imgUrl
                this.dataForm.sort = data.game.sort
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
              url: this.$http.adornUrl(`/game/game/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gameName': this.dataForm.gameName,
                'website': this.dataForm.website,
                'coverUrl': this.dataForm.coverUrl,
                'releaseTime': this.dataForm.releaseTime,
                'gameNameChina': this.dataForm.gameNameChina,
                'gameDescribe': this.dataForm.gameDescribe,
                'price': this.dataForm.price,
                'gameType': this.dataForm.gameType,
                'gameMaking': this.dataForm.gameMaking,
                'gameIssue': this.dataForm.gameIssue,
                'videoUrl': this.dataForm.videoUrl,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'isHot': this.dataForm.isHot,
                'bgUrl': this.dataForm.bgUrl,
                'imgUrl': this.dataForm.imgUrl,
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
