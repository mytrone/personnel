<template>
	<!-- <el-form>
		<el-form-item label="账号">
			<el-input v-model="systemStaff.staffAccount"></el-input>
		</el-form-item>
		<el-form-item label="密码">
			<el-input  v-model="systemStaff.staffCode"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button @click="login()">登录</el-button>
		</el-form-item>
	</el-form> -->
	<div class="login-container">
	        <el-form ref="systemStaff" :rules="loginRules" :model="systemStaff" label-width="80px" class="login-form">
	         <h2 class="login-title">人事管理系统</h2>
	         <el-form-item label="用户名" prop="staffAccount">
	            <el-input v-model="systemStaff.staffAccount"></el-input>
	          </el-form-item>
	          <el-form-item label="密码" prop="staffCode">
	            <el-input type="password" v-model="systemStaff.staffCode"></el-input>
	         </el-form-item>	 
	         <el-form-item>
	           <el-button type="primary" @click="login('systemStaff')">登录</el-button>
	         </el-form-item>
	       </el-form>
	 </div>
</template>

<script>
	export default{
		data(){
			return{
				//登录账户
				systemStaff:{
					staffAccount:'',
					staffCode:''
				},
				//表单校验
				loginRules: {
				  staffAccount: [{ required: true, trigger: 'blur', message: "用户名不能为空" }],
				  staffCode: [{ required: true, trigger: 'blur', message: "请输入密码"}]
				},
			}
		},
		methods:{
			login(val){
				this.$refs[val].validate(valid => {
					if(valid){
						this.axios.post(
							'system/selStaff',this.systemStaff
						).then((v)=>{
							if(v!=null&&v!=''){
								this.$store.state.users = v;
								sessionStorage.setItem("users",JSON.stringify(v))
								this.$router.push('/homepage')
							}else{
								this.$message({
								  message: '登录失败',
								  type: 'error'
								});
							}
						})
					}
				})				
			}
		},
		created() {
		  //清空sessionStorage
		  this.$store.state.users = ''
		  this.$store.state.children = undefined
		  sessionStorage.removeItem("users")
		},
	}
</script>

<style acoped>
   .login-form {
     width: 350px;
     margin: 160px auto; /* 上下间距160px，左右自动居中*/
     background-color: rgb(255, 255, 255, 0.8); /* 透明背景色 */
     padding: 30px;
     border-radius: 20px; /* 圆角 */
   }
 
   /* 背景 */
   .login-container {
     position: absolute;
     width: 100%;
     height: 100%;
     background: url("../assets/login.jpg");
   }

   /* 标题 */
   .login-title {
     color: #303133;
     text-align: center;
   }
   </style>
