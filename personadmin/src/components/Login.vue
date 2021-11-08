<template>
	<el-form>
		<el-form-item label="账号">
			<el-input v-model="systemStaff.staffAccount"></el-input>
		</el-form-item>
		<el-form-item label="密码">
			<el-input  v-model="systemStaff.staffCode"></el-input>
		</el-form-item>
		<el-form-item>
			<el-button @click="login()">登录</el-button>
		</el-form-item>
	</el-form>
</template>

<script>
	export default{
		data(){
			return{
				//登录账户
				systemStaff:{
					staffAccount:"admin",
					staffCode:123456
				}				
			}
		},
		methods:{
			login(){
				this.axios.post(
					'system/selStaff',this.systemStaff
				).then((v)=>{
					if(v!=null&&v!=''){
						this.$store.state.users = v;
						sessionStorage.setItem("users",JSON.stringify(v))
						this.$router.push('/')
					}else{
						this.$message({
						  message: '登录失败',
						  type: 'error'
						});
					}
				})
			}
		},
		created(){
			
		}
	}
</script>

<style>
</style>
