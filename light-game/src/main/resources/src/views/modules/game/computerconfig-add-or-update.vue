<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="最低配置和推荐配置，最低为0，推荐为1" prop="type">
      <el-input v-model="dataForm.type" placeholder="最低配置和推荐配置，最低为0，推荐为1"></el-input>
    </el-form-item>
    <el-form-item label="操作系统" prop="systemOs">
      <el-input v-model="dataForm.systemOs" placeholder="操作系统"></el-input>
    </el-form-item>
    <el-form-item label="内存" prop="computerRam">
      <el-input v-model="dataForm.computerRam" placeholder="内存"></el-input>
    </el-form-item>
    <el-form-item label="显卡" prop="computerVram">
      <el-input v-model="dataForm.computerVram" placeholder="显卡"></el-input>
    </el-form-item>
    <el-form-item label="cpu" prop="computerCpu">
      <el-input v-model="dataForm.computerCpu" placeholder="cpu"></el-input>
    </el-form-item>
    <el-form-item label="硬盘" prop="computerHard">
      <el-input v-model="dataForm.computerHard" placeholder="硬盘"></el-input>
    </el-form-item>
    <el-form-item label="网络" prop="computerNetwork">
      <el-input v-model="dataForm.computerNetwork" placeholder="网络"></el-input>
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
          type: '',
          systemOs: '',
          computerRam: '',
          computerVram: '',
          computerCpu: '',
          computerHard: '',
          computerNetwork: ''
        },
        dataRule: {
          type: [
            { required: true, message: '最低配置和推荐配置，最低为0，推荐为1不能为空', trigger: 'blur' }
          ],
          systemOs: [
            { required: true, message: '操作系统不能为空', trigger: 'blur' }
          ],
          computerRam: [
            { required: true, message: '内存不能为空', trigger: 'blur' }
          ],
          computerVram: [
            { required: true, message: '显卡不能为空', trigger: 'blur' }
          ],
          computerCpu: [
            { required: true, message: 'cpu不能为空', trigger: 'blur' }
          ],
          computerHard: [
            { required: true, message: '硬盘不能为空', trigger: 'blur' }
          ],
          computerNetwork: [
            { required: true, message: '网络不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/game/computerconfig/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.type = data.computerConfig.type
                this.dataForm.systemOs = data.computerConfig.systemOs
                this.dataForm.computerRam = data.computerConfig.computerRam
                this.dataForm.computerVram = data.computerConfig.computerVram
                this.dataForm.computerCpu = data.computerConfig.computerCpu
                this.dataForm.computerHard = data.computerConfig.computerHard
                this.dataForm.computerNetwork = data.computerConfig.computerNetwork
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
              url: this.$http.adornUrl(`/game/computerconfig/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'type': this.dataForm.type,
                'systemOs': this.dataForm.systemOs,
                'computerRam': this.dataForm.computerRam,
                'computerVram': this.dataForm.computerVram,
                'computerCpu': this.dataForm.computerCpu,
                'computerHard': this.dataForm.computerHard,
                'computerNetwork': this.dataForm.computerNetwork
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
