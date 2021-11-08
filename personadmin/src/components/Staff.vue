<template>
	<el-row :gutter="16">
		<el-form>
			<el-col :span="13">
			<el-form-item label="用户搜索">
				<el-input v-model="value" placeholder="请输入用户账号">					
				</el-input>
			</el-form-item>
			</el-col>
			<el-col :span="11">
				<el-form-item>
					<el-button @click="selStaff">查询</el-button>
					<el-button @click="dialogVisible=true">新增</el-button>
				</el-form-item>
			</el-col>
		</el-form>		
	</el-row>
	<el-table :data="staffs.slice((currentPage-1)*pagesize,currentPage*pagesize)">
		<el-table-column prop="staffId" label="用户编号"></el-table-column>
		<el-table-column prop="staffAccount" label="用户账号"></el-table-column>
		<el-table-column prop="archivesEmp.empName" label="姓名"></el-table-column>
		<el-table-column prop="department.departmentName" label="部门"></el-table-column>
		<el-table-column prop="post.postName" label="职位"></el-table-column>
		<el-table-column label="是否锁定">
			<template v-slot:default="v">
				{{v.row.staffState==0?"否":"是"}}
			</template>
		</el-table-column>
		<el-table-column label="操作">
			<template v-slot:default="v">
				<el-button @click="changeStaff(v.row)" size="mini">修改</el-button>
			</template>
		</el-table-column>
	</el-table>
	<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" layout="total, sizes, prev, pager, next, jumper"
	 :page-size="pagesize" :page-sizes="[5, 10, 15]" :total="staffs.length">
	</el-pagination>
	<el-dialog v-model="dialogVisible" @close="restStaff">
		<el-form ref="staff" :rules="staffRule" :model="staff">
			<el-row :gutter="20">
				<el-col :span="10">
					<el-form-item prop="empId" label="用户档案">
						<el-input v-model="staff.empId"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-form-item prop="staffAccount" label="用户账号">
						<el-input v-model="staff.staffAccount"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row :gutter="20">
				<el-col :span="10">
					<el-form-item prop="staffCode" label="用户密码">
						<el-input v-model="staff.staffCode"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="10">
					<el-form-item label="账号锁定" prop="staffState">
						<el-select v-model="staff.staffState">
							<el-option label="是" :value='1'></el-option>
							<el-option label="否" :value='0'></el-option>
						</el-select>
					</el-form-item>
				</el-col>
			</el-row>
			<el-form-item>
				<el-table :data="roles" height="200" @selection-change="handleSelectionChange" ref="multipleTable">
					<el-table-column type="selection" width="55"></el-table-column>
					<el-table-column prop="roleId" label="编号"></el-table-column>
					<el-table-column prop="roleName" label="角色名"></el-table-column>
				</el-table>
			</el-form-item>
			<el-form-item>
				<el-button @click="addStaff('staff')">确认</el-button>
				<el-button @click="restStaff">取消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	export default{
		data(){
			return{
				//接收后台传递来的用户
				posts:[],
				//传递到后台的用户对象
				staff:{
					staffId:'',
					empId:'',
					staffAccount:'',
					staffCode:'',
					staffState:''
				},
				//控制弹框的打开
				dialogVisible:false,
				//接受勾选的角色id
				roleIds:[],
				//接受后台传递来的用户
				staffs:[],
				//绑定角色搜索框
				value:'',
				//初始页
				currentPage: 1, 
				 //每页的数据
				pagesize: 5,
				//表单校验
				staffRule:{
					empId:[{
						required: true,
						message: "请选择档案",
						trigger: "blur"
					}],
					staffAccount:[{
						required: true,
						message: "请输入账号",
						trigger: "blur"
					}],
					staffCode:[{
						required: true,
						message: "请输入密码",
						trigger: "blur"
					}],
					staffState:[{
						required: true,
						message: "请选择状态",
						trigger: "blur"
					}]
				}
			}
		},
		methods:{
			//新增或修改用户
			addStaff(val){
				this.$refs[val].validate(valid => {
					if(valid){
						if(this.staff.staffId==''){
							//新增用户
							this.axios.post(
								'system/addStaff',{
									systemStaff:this.staff,roleIds:this.roleIds
								}
							).then((v)=>{
								if(v=="yes"){
									this.restStaff(),
									this.selStaff(),
									this.$message({
									  message: '用户信息新增成功',
									  type: 'success'
									});
								}else{
									this.$message({
									  message: '当前账户名已使用',
									  type: 'warning'
									});
								}								
							})
						}else{
							//修改用户
							this.axios.post(
								'system/changeStaff',{
									systemStaff:this.staff,roleIds:this.roleIds
								}
							).then((v)=>{
								this.restStaff(),
								this.selStaff(),
								this.$message({
								  message: '用户信息修改成功',
								  type: 'success'
								});
							})
						}
					}
				})				
			},
			//查看用户
			selStaff(){
				this.axios({
					url:'system/selStaffByAccount',
					params:{
						staffAccount:this.value
					}
				}).then((v)=>{
					this.staffs=v
				})
			},
			//查看角色
			selRole(){
				this.axios({
					url:'system/selRole'
				}).then((v)=>{
					this.roles=v
				})
			},
			//获取勾选的角色
			handleSelectionChange(val){
				this.roleIds=[],
				val.forEach(f=>{
					this.roleIds.push(f.roleId)
				});
			},
			//将对象属性传给表单
			changeStaff(val){
				this.roleIds=[],
				this.staff.staffId=val.staffId,
				this.staff.empId=val.empId,
				this.staff.staffAccount = val.staffAccount, 
				this.staff.staffCode = val.staffCode, 
				this.staff.staffState = val.staffState,
				this.axios({
					url:'system/selRoleByStaffId',
					params:{
						staffId:val.staffId
					}
				}).then((v)=>{
					this.dialogVisible=true,
					//勾选已有角色
					v.forEach((row,item)=>{
						this.roleIds.push(row.roleId);
						console.log("记录"+this.roleIds)
						this.roles.forEach((r,index)=>{
							if(row.roleId==r.roleId){
								this.$nextTick(function() {
									this.$refs.multipleTable.toggleRowSelection(this.roles[index],true);
									return 
								})
							}
						})												
					})					
				})
			},
			//重置表单内容
			restStaff(){
				this.staff={
					staffId:'',
					empId:'',
					staffAccount:'',
					staffCode:'',
					staffState:''
				},
				this.dialogVisible=false,
				this.$refs.multipleTable.clearSelection();
			},
			handleSizeChange: function(size) {
				this.pagesize = size;
			},
			handleCurrentChange: function(currentPage) {
				this.currentPage = currentPage;
			},
		},
		created(){
			this.selRole(),
			this.selStaff()
		}
	}
</script>

<style>
</style>
