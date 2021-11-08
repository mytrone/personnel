<template>
	<div class="overtime">
		<el-row style="text-align: center;font-size: 26px;">
			<el-col>加班申请</el-col>
		</el-row>

		<el-row style="margin-top: 18px;">
			<el-col>
				基本信息
			</el-col>
		</el-row>
		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请人：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="userName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请部门：
			</el-col>
			<el-col :span="4">
				<el-input type="text" v-model="dept.deptName" disabled size="small"></el-input>
			</el-col>
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				申请职位：
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
				加班时长：
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

			</el-col>
			<el-col :span="4">

			</el-col>
		</el-row>

		<el-row style="margin-top: 12px;">
			<el-col style="text-align: right;line-height: 32px;" :span="3">
				说明：
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
				<el-button type="primary" size="mini" round @click="insertOver">保存</el-button>
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
				dept: {
					deptId: 7,
					deptName: "人事部"
				},
				post: {
					postId: 1,
					postName: "员工"
				},
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
				explain: ""
			}
		},
		methods: {
			insertOver() {
				this.axios.post("overtime/insertOvertime", {
					empId: 1,
					deptId: this.dept.deptId,
					spr: this.value,
					typeName: "加班申请",
					flowId: this.flowsId,
					postId: this.post.postId,
					start: this.statr,
					finish: this.finsh,
					reason: this.duration,
					explain: this.explain
				}).then(res => {
					console.log(res)
					if (res > 0) {
						ElMessage({
							message: "申请成功",
							type: 'success'
						});
						this.$router.push({
							name: "clockinginovertime"
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

		}
	}
</script>

<style>
	.overtime {
		width: 98%;
		margin: 0 auto;
	}
</style>
