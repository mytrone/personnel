<template>
	<div class="overtime">
		<el-row style="text-align: center;font-size: 26px;">
			<el-col>请假申请</el-col>
		</el-row>

		<el-row style="margin-top: 18px;">
			<el-col>
				基本信息
			</el-col>
		</el-row>
		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				请假人：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="emp.empName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				部门：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="dept.departmentName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				职位：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="post.postName" disabled size="small"></el-input>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				开始时间：
			</el-col>
			<el-col :span="4">
				<el-date-picker v-model="statr" type="datetime" placeholder="开始时间">
				</el-date-picker>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				结束时间：
			</el-col>
			<el-col :span="4">
				<el-date-picker v-model="finsh" type="datetime" placeholder="结束时间">
				</el-date-picker>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				请假天数：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="duration" size="small"></el-input>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				审批人：
			</el-col>
			<el-col :span="4">
				<el-select v-model="value" placeholder="审批人">
					<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				审批流程：
			</el-col>
			<el-col :span="4">
				<el-select v-model="flowsId" placeholder="审批流程">
					<el-option v-for="item in flows" :key="item.value" :label="item.label" :value="item.value">
					</el-option>
				</el-select>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				请假类型：
			</el-col>
			<el-col :span="4">
				<el-select v-model="akesId" placeholder="审批流程">
					<el-option v-for="item in akes" :key="item.alinkeyId" :label="item.alinkeyName" :value="item.alinkeyId">
					</el-option>
				</el-select>
			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				请假事由：
			</el-col>
			<el-col :span="18">
				<el-input v-model="explain" :autosize="{ minRows: 4}" type="textarea" placeholder="说明">
				</el-input>
			</el-col>
		</el-row>


		<el-row style="margin-top: 12px;">
			<el-col :span="5">

			</el-col>
			<el-col :span="5">

			</el-col>
			<el-col :span="6">

			</el-col>
			<el-col style="text-align: right;" :span="5">
				<el-button type="primary" size="mini" round @click="insertOver">保存且新增</el-button>
			</el-col>
		</el-row>

	</div>
</template>

<script>
	import moment from 'moment'
	import {
		ElMessageBox,
		ElNotification,
		ElMessage
	} from 'element-plus'
	import qs from 'qs'

	export default {
		data() {
			return {
				userName: "层旭",
				/* dept: {
					deptId: 7,
					deptName: "人事部"
				}, */
				/* post: {
					postId: 1,
					postName: "员工"
				}, */
				statr: "",
				finsh: "",
				duration: "",
				options: [{
						value: '1',
						label: '审批人',
					},
					{
						value: '2',
						label: 'Option2',
					}
				],
				value: '',
				flows: [{
						value: '58',
						label: 'Option1',
					},
					{
						value: '59',
						label: 'Option2',
					}
				],
				flowsId: "",
				explain: "",
				akesId:"",
				emp: [],
				dept: [],
				post: [],
				akes:[]
			}
		},
		methods: {
			original() {
				this.dept = this.$store.state.users.department;
				this.emp = this.$store.state.users.archivesEmp;
				this.post = this.$store.state.users.post;
				this.axios.get("leave/selectAlinkey",{
					params:{
						alinkId:18
					}
				}).then(res=>{
					console.log(res)
					this.akes=res
				});
			},
			insertOver() {
				this.axios.post("leave/insertLeave", {
					empId: 1,
					deptId: this.dept.deptId,
					spr: this.value,
					alinkId: this.akesId,
					flowId: this.flowsId,
					postId: this.post.postId,
					start: this.statr,
					finish: this.finsh,
					reasons: this.duration,
					explain: this.explain
				}).then(res => {
					console.log(res)
					if (res > 0) {
						ElMessage({
							message: "申请成功",
							type: 'success'
						});
						this.$router.push({
							name: "clockinginleave"
						})
					} else {
						ElNotification({
							title: 'Error',
							message: '申请失败',
							type: 'error',
						})
					}
				});
			}
		},
		mounted() {
			this.original();
		}
	}
</script>

<style>
	.overtime {
		width: 98%;
		margin: 0 auto;
	}
</style>
