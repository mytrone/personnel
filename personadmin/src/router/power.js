import axios from 'axios'

//初始化菜单
export const initMenu = (router,store,to,next)=>{
	//如果vuex的状态管理中存在路由信息，则不需要再次请求
	if(store.state.children!= null && store.state.children.length > 0){		
		next()
		return;
	}
	//获取用户信息
	if(JSON.parse(sessionStorage.getItem("users")) != null || store.state.users != ''){		
		axios({url:"system/selAuthorityByStaffId",params:{staffId:store.state.users.staffId}}).then(resp=>{
			if (resp.length!=0) {
				console.log(resp)
			    //let res = resp.data;
			        //1、对后台查询到的菜单信息，就行格式化，主要目的是：要符合Vue的路由的要求
			        var fmtRoutes = formatRoutes(resp);
			        //2、将菜单信息，添加到路由对象中,因为home是顶级的路由，所以直接写死			  
					fmtRoutes.forEach(row=>{
						row.children.forEach(r=>{
							router.addRoute("Home",r);
						})
					})
					//3、调用./src/store/index.js中的方法initMenu，参数是格式化之后的菜单数组
			        store.commit('initMenu',fmtRoutes);
					next({...to,replace:true})			 
			}
		})
	}

}
//批量导入
const modules = import.meta.glob('../**/**')

//组装路由
export const formatRoutes = (routes) => {
	let fmRoutes = [];
	routes.forEach(router => {
		let {
			authorityName,
			authorityAccess,
			authorityPath,
			authorityIoc,
			authorityChilds,
		} = router; //取数据库的数据

		if (authorityChilds && authorityChilds instanceof Array) {
            authorityChilds = formatRoutes(authorityChilds);
		}
		let fmRouter = {};
		if (router.authorityAccess == null) {
			fmRouter = {
				name: authorityName,
				children: authorityChilds
			}
		} else {
			fmRouter = {
				path: authorityPath,
				name: authorityName,
				component: modules[`../components/${authorityAccess}.vue`],
				children: authorityChilds
			}
			console.log("这是指向vue"+fmRouter.component)
		}
		fmRoutes.push(fmRouter);
	});

	return fmRoutes;
}
