 <template>
	 <el-dialog title="投递简历" v-model="centerDialogVisible2" width="60%">
		 <div class="bod">
		 <el-form ref="form" :model="form" label-width="100px">
		 		<el-form-item label="姓名">
		 			<div style="width: 420px;">
		 				<el-input v-model="form.name"></el-input>
		 			</div>
		 		</el-form-item>
		   	<el-form-item label="学历信息">
		   		<div style="width: 420px;">
		   		<el-select  v-model="form.xueli" placeholder="请选择">
		   		    <el-option
		   		      v-for="item in options"
		   		      :key="item.value"
		   		      :label="item.label"
		   		      :value="item.value">
		   		    </el-option>
		   		  </el-select>
		   		</div>  
		   	</el-form-item>
			<el-form-item>
		     <el-button type="primary" @click="resumeson()">提交</el-button>
		   </el-form-item>
		 </el-form>
		 </div>
	 </el-dialog>
	 <el-dialog title="招聘详情" v-model="centerDialogVisible" width="60%">
	 	<span>
	 		<!-- {{check}} -->
	 		<!-- <el-row>
	 			<el-col>
	 				招聘详情
	 			</el-col>
	 		</el-row> -->
	 		<el-row style="margin-top: 21px;">
	 			<el-col class="el-co" :span="3">
	 				公司名称：
	 			</el-col>
	 			<el-col :span="4">
	 				<div class="one">
	 					
	 				</div>
	 			</el-col>
	 			<el-col class="el-co" :span="3">
	 				招聘岗位：
	 			</el-col>
	 			<el-col :span="4">
	 				<div class="one">
						{{xinxi.demandPosition}} 					
	 				</div>
	 			</el-col>
	 			<el-col class="el-co" :span="3">
	 				发布时间：
	 			</el-col>
	 			<el-col :span="5">
	 				<div class="one e" >
	 					{{xinxi.demandTime}}
	 				</div>
	 			</el-col>
	 		</el-row>
	 
	 		<el-row style="margin-top: 21px;">
	 			
	 		</el-row>
	 		<el-row style="margin-top: 21px;">
	 			<el-col class="el-co" :span="3">
	 				需求人数：
	 			</el-col>
	 			<el-col :span="4">
	 				<div class="one">
	 					<!-- {{xinxi.demandPnum}}  &nbsp;人 -->
	 				</div>
	 			</el-col>
	 			<el-col class="el-co" :span="3">
	 				工作年限：
	 			</el-col>
	 			<el-col :span="4">
	 				<div class="one">
	 					{{xinxi.demandWorkyear}}
	 				</div>
	 			</el-col>
				<el-col class="el-co" :span="3">
					学历信息：
				</el-col>
				<el-col :span="4">
					<div class="one">
						<!-- {{check.positiontableByPositiontableId.positiontableName}} -->
					</div>
				</el-col>
	 		</el-row>
	 
			<el-row align="middle" style="margin-top: 21px;">
				<el-col class="el-co" :span="3">
					职位要求：
				</el-col>
				<el-col :span="21">
					<el-input v-if="article!==null" v-model="xinxi.demandPositionInf" disabled style="color: #000000;" 
						:rows="3"/>						
				</el-col>
			</el-row>
			<el-row style="margin-top: 21px;">
				<el-col class="el-co" :span="3">
					薪资范围：
				</el-col>
				<el-col :span="5">
					<div class="one">
						{{xinxi.demandMoney}}
					</div>
				</el-col>
				<el-col class="el-co" :span="3">
					发布人：
				</el-col>
				<el-col :span="5">
					<div class="one">
						
					</div>
				</el-col>
			</el-row>
				<span style="right: auto;">
					<el-button class="toudi" type="primary" @click="this.centerDialogVisible2=true">投递简历</el-button>
				</span>		
	 	</span>
	 </el-dialog>
	 
    <el-table
      :data="tableData"
      style="width: 100%">
      <!-- <el-table-column
        prop="demandName"
        label="发布人"
        width="180">
      </el-table-column> -->
	  <el-table-column
	    prop="demandPosition"
	    label="招聘岗位"
	    width="180">
	  </el-table-column>
      <!-- <el-table-column
        prop="demandPositionInf"
        label="岗位信息"
        width="180">
      </el-table-column> -->
	  <!-- <el-table-column
	    prop="recruitRecruitapplyByRecruitapplyId.recruitapplyPnum"
	    label="需求人数"
	    width="180">
	  </el-table-column> -->
      <el-table-column
        prop="demandAddress"
        label="地址">
      </el-table-column>
	  <!-- <el-table-column
	    prop="demandTel"
	    label="联系方式(电话)">
	  </el-table-column> -->
	  <el-table-column
	    prop="demandAddress"
	    label="地址">
	  </el-table-column>
	  <el-table-column
	    prop="demandTime"
	    label="发布时间">
	  </el-table-column>
	  <el-table-column label="操作">
		 <template #default="scope">
			<el-button @click="istrue(scope.row)">查看</el-button>
		 </template>
	  </el-table-column>
    </el-table>
  </template>

<script lang="ts">
import { Timer } from '@element-plus/icons'

export default {
  data() {
    return {
		options: [{
		          value: '中专及以上',
		          label: '中专及以上'
		        }, {
		          value: '高中及以上',
		          label: '高中及以上'
		        }, {
		          value: '大专及以上',
		          label: '大专及以上'
		        }, {
		          value: '本科及以上',
		          label: '本科及以上'
		        }, {
		          value: '硕士研究生',
		          label: '硕士研究生'
		        }, {
		          value: '博士研究生',
		          label: '博士研究生'
		        }],
		        value: '',
	  form:{
		  name:'',
		  xueli:''
	  },
	  xinxi:{},//行数据	
	  tableData:[],//招聘信息表数据
	  centerDialogVisible:false,
	  centerDialogVisible2:false
    }
  },
  methods: {
	//投递简历
	resumeson(){
		this.axios.post("recruitLookjl/insertrecruitLookjl",{
				  lookjlName:this.form.name,
				  lookjlStudy:this.form.xueli
		}
		).then(res=>{
			console.log("res",res)
			if (res == 1) {
			    alert("新增成功");
			} else {
			    alert("新增失败");
			}
		}).catch(e=>{
			console.log(e)
		})
	},
	//查看
	istrue(row){
		this.axios.get("recruitDemand/selectDemandId",{
			params: {
				demandId:row.demandId,
			}
		}).then(res => {
            this.xinxi =row
            console.log("xinxi",res);
          })
		this.centerDialogVisible=true
	},
    selectAll(){
    	this.axios.post("recruitDemand/selectDemand").then(res=>{
    		this.tableData=res
    		console.log("tableData",this.tableData)
    	})
    }
  },created() {
	  this.selectAll()
  }
}
</script>

<style scoped="scoped">
	.one {
		width: 60%;
		height: 100%;
		border-bottom: 1px solid #000000;
		text-align: center;
	}
	.toudi{
		margin-top: 50px;
		margin-left: 45%;
	}
</style>
  
  