<template>
	<div class="divOne">
		<el-row>
			<el-col :span="8" style="font-size: 12px;">
				<div class="punchDiv">
					<el-row>
						<el-col>
							考勤打卡
						</el-col>
					</el-row>

					<el-row style="margin-top: 8px;">
						<el-col :span="12">
							{{nowDate}} {{weeks}}<br>
							<span style="font-size: 18px;">{{hour}}</span>
						</el-col>

						<el-col style="text-align: right;" :span="12">
							<el-button type="primary" :disabled="frequency.length==2 || frequency.length==4" @click="signin(frequency.length)">
								{{frequency.length==0?"上班签到":
								frequency.length==1?"下班签到":"完成打卡"
								}}<!-- frequency.length==2?"加班上班签到":
								frequency.length==3?"加班下班签到":"" -->
								
							</el-button>
						</el-col>

					</el-row>

					<el-row style="margin-top: 28px;margin-bottom: 18px;">
						<el-col :span="10">
							上班时间：9:00
						</el-col>
						<el-col :span="14">
							<span v-if="frequency.length>0">
								打卡时间：{{frequency[0].punchCard}}<!-- {{dates}} --> &nbsp;&nbsp;
								{{frequency[0].alinkeyByAlinkeyId.alinkeyName}}
							</span>
						</el-col>
					</el-row>

					<hr />

					<el-row style="margin-top: 18px;margin-bottom: 18px;">
						<el-col :span="10" style="font-size: 6px;">
							下班时间：18:00
						</el-col>
						<el-col :span="14">
							<span v-if="frequency.length>0">
								打卡时间：{{frequency[1].punchCard}}<!-- {{dates}} --> &nbsp;&nbsp;
								{{frequency[1].alinkeyByAlinkeyId.alinkeyName}}
							</span>
						</el-col>
					</el-row>

				</div>
			</el-col>
			<el-col :span="8">

			</el-col>
			<el-col :span="8">

			</el-col>
		</el-row>
		<!-- <el-button type="primary">6</el-button> -->
	</div>
</template>

<script>
	import moment from 'moment'
	import {
		ElMessageBox,
		ElMessage
	} from 'element-plus'
	import qs from 'qs'

	export default {
		data() {
			return {
				nowDate: "", // 当前日期
				weeks: "",
				hour: "",
				punchState: "上班",
				state: "",
				frequency: [] //打卡次数  计算属于下次打卡属于打卡类型
			};
		},
		/* computed: {
			dates(iter){
				console.log(iter.frequency[0].punchCard,"时间");
				let v=moment(iter.frequency[0].punchCard).format("HH:mm:ss")
				console.log(v)
				return v;
			}
		}, */
		methods: {
			punch() {
				/* 查询当前是发以打卡 */
				this.axios.get("punch", {
					params: {
						empid: 1
					}
				}).then(res => {
					if (res != null) {
						console.log(res)
						res.forEach(r=>{
							console.log(r,4)
							r.punchCard=moment(r.punchCard).format("HH:mm:ss")
						})
						this.frequency = res
					}

				});
			},
			signin(index) {
				console.log(this.nowDate)
				console.log(this.hour)
				if(index+1<3){
					console.log(index,"=====")
					if (this.hour === "18:00") {
						this.state = "正常";
						console.log("正常打卡")
					} else if (this.hour < "18:00") {
						this.state = "早退";
						console.log("当前打卡为早退")
					}
				}
				
				/* this.axios.post("punch/addPunch", qs.stringify({
					date: this.nowDate + " " + this.hour,
					empid: 1,
					state: this.state
				})).then(res => {
					console.log(res)
					if (res > 0) {
						ElMessage({
							message: "打卡成功",
							type: 'success'
						});
						this.punch();
					}
				}); */
			},
			currentTime() {
				setInterval(this.formatDate, 1000);
			},
			formatDate() {
				let date = new Date();
				let year = date.getFullYear(); // 年
				let month = date.getMonth() + 1; // 月
				let day = date.getDate(); // 日
				let week = date.getDay(); // 星期
				let weekArr = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
				let hour = date.getHours(); // 时
				hour = hour < 10 ? "0" + hour : hour; // 如果只有一位，则前面补零
				let minute = date.getMinutes(); // 分
				minute = minute < 10 ? "0" + minute : minute; // 如果只有一位，则前面补零
				let second = date.getSeconds(); // 秒
				second = second < 10 ? "0" + second : second; // 如果只有一位，则前面补零
				this.weeks = `${weekArr[week]}`
				this.hour = `${hour}:${minute}:${second}`
				this.nowDate = `${year}-${month}-${day}`;
			},
		},
		mounted() {
			this.punch(); /* 查询当前是发以打卡 */
			this.currentTime();
		}
	}
</script>

<style scoped>
	.punchDiv {
		width: 100%;
		height: 100%;
		border: 1px #B3C0D1 solid;
	}

	.divOne {
		width: 100%;
		margin: 0 auto;
	}
</style>
