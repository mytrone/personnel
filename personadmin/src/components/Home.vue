<template>
	<el-container style="height: 730px; border: 1px solid #eee">
		<el-aside width="200px" style="background-color: rgb(238, 241, 246)">


			<el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="99"
			 text-color="#fff" @open="handleOpen" @close="handleClose">

				<el-menu-item index="99">
					<el-icon>
						<icon-menu />
					</el-icon>
					<!-- <span> -->
					<router-link to="homepage">
						首页
					</router-link>
					<!-- </span> -->
				</el-menu-item>
				<!-- <el-menu-item index="1-7">
					<router-link to="apply">审批人选择</router-link>
				</el-menu-item>
				<el-menu-item index="1-8">
					<router-link to="applys">下一个审批人</router-link>
				</el-menu-item>

				<el-sub-menu index="1">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>工作流程</span>
					</template>

					<el-menu-item index="1-1">
						<router-link to="flowdesign">流程设计</router-link>
					</el-menu-item>
					<el-menu-item index="1-2">
						<router-link to="flowmonitoring">流程监控</router-link>
					</el-menu-item>
					<el-menu-item index="1-3">
						<router-link to="flowprocess">我的申请</router-link>
					</el-menu-item>
					<el-menu-item index="1-4">
						<router-link to="flowagency">代办流程</router-link>
					</el-menu-item>
					<el-menu-item index="1-5">
						<router-link to="flowentrust">委托流程</router-link>
					</el-menu-item>
					<el-menu-item index="1-6">
						<router-link to="flownotice">抄送事宜</router-link>
					</el-menu-item>

				</el-sub-menu>
				<el-sub-menu index="2">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>招聘管理</span>
					</template>
					<el-menu-item index="2-1">
						
							<router-link to="recruit_yrensq">用人申请</router-link>
						
					</el-menu-item>
					<el-menu-item index="2-2">
						
							<router-link to="recruit_demand">发布招聘信息</router-link>
						
					</el-menu-item>
					<el-menu-item index="2-3">
						
							<router-link to="recruit_demandSelect">查看招聘信息</router-link>
						
					</el-menu-item>
					<el-menu-item index="2-4">
						
							<router-link to="recruit_recruitapplySelect">查看用人申请单</router-link>
						
					</el-menu-item>
					<el-menu-item index="2-5">
						
							<router-link to="recruit_lookjl">查看简历</router-link>
						
					</el-menu-item>
				</el-sub-menu>
				<el-sub-menu index="3">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>考勤管理</span>
					</template>
					<el-menu-item index="3-1">
						<router-link to="clockinginovertime">加班申请记录</router-link>
					</el-menu-item>
					<el-menu-item index="3-2">
						<router-link to="clockinginleave">请假申请记录</router-link>
					</el-menu-item>
				</el-sub-menu>
				<el-sub-menu index="4">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>绩效管理</span>
					</template>

					<el-menu-item index="4-1">
						<router-link to="financeItem">考核项目</router-link>
					</el-menu-item>
					<el-menu-item index="4-2">
						<router-link to="financeTemplate">考核模板</router-link>
					</el-menu-item>
					<el-menu-item index="4-3">
						<router-link to="financeCheck">员工考核</router-link>
					</el-menu-item>
				</el-sub-menu>
				<el-sub-menu index="5">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>薪资管理</span>
					</template>
					<el-menu-item index="5-1">
						<router-link to="financeSalarys">工资发放</router-link>
					</el-menu-item>
					<el-menu-item index="5-2">
						<router-link to="financeSubmit">报销管理</router-link>
					</el-menu-item>
				</el-sub-menu>
				<el-sub-menu index="6">
					<template #title>
						<el-icon style="margin-right: 15px">
							<setting />
						</el-icon>
						<span>系统设置</span>
					</template>
					<el-menu-item index="6-1">
						<router-link to="staff">用户管理</router-link>
					</el-menu-item>
					<el-menu-item index="6-2">
						<router-link to="role">角色管理</router-link>
					</el-menu-item>
					<el-menu-item index="6-3">
						<router-link to="department">部门管理</router-link>
					</el-menu-item>
					<el-menu-item index="6-4">
						<router-link to="post">职位管理</router-link>
					</el-menu-item>
				</el-sub-menu> -->
			</el-menu>
			<el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="99"
			 text-color="#fff" @open="handleOpen" @close="handleClose">
				<span v-for="(iter,index) in path">
					<el-sub-menu :index=index><template #title>
							<el-icon style="margin-right: 15px">
								<setting />
							</el-icon>
							<span>
								{{iter.name}}</span>
						</template>
						<span v-for="(iter2,index2) in iter.children">
							<el-menu-item :index="index+'-'+index2">
								<router-link :to="iter2.path">{{iter2.name}}</router-link>
							</el-menu-item>
						</span>
					</el-sub-menu>
				</span>
			</el-menu>

		</el-aside>

		<el-container>
			<el-header style="text-align: right; font-size: 12px">
				<el-dropdown>

					<el-icon style="margin-right: 15px">
						<setting />
					</el-icon>
					<template #dropdown>
						<el-dropdown-menu>
							<el-dropdown-item @click="logOut">退出登录</el-dropdown-item>
							<el-dropdown-item @click="disable=true">修改密码</el-dropdown-item>
						</el-dropdown-menu>
					</template>
				</el-dropdown>
				<span>欢迎,{{this.$store.state.users.archivesEmp.empName}}</span>
			</el-header>
			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
	<el-dialog v-model="disable" title="密码修改" width="40%">
		<el-form ref="staff" :model="staff" :rules="staffRules" label-width="150px">
			<el-form-item label="原密码" prop="value">
				<el-input type="password" v-model="staff.value" style="width: 250px;"></el-input>
			</el-form-item>
			<el-form-item label="新密码" prop="staffCode">
				<el-input type="password" v-model="staff.staffCode" style="width: 250px;"></el-input>
			</el-form-item>
			<el-form-item label="确认密码" prop="value2">
				<el-input type="password" v-model="staff.value2" style="width: 250px;"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="changeCode('staff')">确认</el-button>
				<el-button @click="cancelCode">取消</el-button>
			</el-form-item>
		</el-form>
	</el-dialog>
</template>

<script>
	import {defineComponent,ref} from 'vue'
	import {Message,Menu,Setting} from '@element-plus/icons'
	export default {
		components: {
			Message,
			Setting,
			'icon-menu': Menu,
		},
		data() {
			return {
				//用户权限
				path: '',
				//用户信息
				staff: {
					staffId: '',
					staffCode: '',
					value: '',
					value2: '',
				},
				//控制弹框
				disable: false,
				staffRules:{
					value:[{
						required: true,
						message: "请输入原密码",
						trigger: "blur"
					}],
					staffCode:[{
						required: true,
						message: "请输入密码",
						trigger: "blur"
					}],
					value2:[{
						required: true,
						message: "请输入二次密码",
						trigger: "blur"
					}]
				}
			}
		},
		methods: {
			logOut() {
				this.$router.push('/login')
			},
			//修改密码
			changeCode() {
				this.staff.staffId = this.$store.state.users.staffId;
				if (this.staff.value != this.$store.state.users.staffCode) {
					this.$message.error('原密码错误');
				} else if (this.staff.staffCode != this.staff.value2) {
					this.$message.error('密码确认不一致');
				} else {
					this.axios.post(
						'system/changeStaffCode', this.staff
					).then((v) => {
						this.$message({
							message: '密码修改完成',
							type: 'success'
						});
						this.logOut()
					})
				}
			},
			//取消修改
			cancelCode(){
				this.value="",
				this.value2="",
				this.staff.staffCode=""
			}
		},
		created() {
			this.path = this.$store.state.children,
				this.user = this.$store.state.users
		}
	}
</script>


<style>
	.el-header {
		background-color: #b3c0d1;
		color: var(--el-text-color-primary);
		line-height: 60px;
	}

	.el-aside {
		color: var(--el-text-color-primary);
	}

	.el-submenu.is-opened>.el-submenu__title .el-submenu__icon-arrow {
		color: deeppink;
	}

	.el-submenu__title i {
		color: yellow;
	}

	.el-aside a {
		text-decoration: none;
		color: inherit;
		/* inherit继承 */
	}
</style>
