import { createApp } from 'vue'
import Start from '@/Start.vue'
// /* 1、导入element-plus */
import ElementPlus from 'element-plus'

import locale from 'element-plus/lib/locale/lang/zh-cn'
import 'element-plus/dist/index.css'

/* 2、导入axios */
import axios from '@/axios/index.js'
import VueAxios from 'vue-axios'
/* 3、导入路由 */
import router from '@/router/index.js'
// 引入vuex的store对象
import store from '@/store/index.js'
import {initMenu} from '@/router/power.js'
//准备加载路由
router.beforeEach((to,from,next)=>{
    if(to.path=='/login' ){
        return  next();
    }
    if(sessionStorage.getItem('users')==null || store.state.users==null){
        return next("/login")
    }else{
        initMenu(router,store,to,next);
    }
})

/* 1、创建Vue对象 */
let app = createApp(Start)
/* 2、导入element-plus */
app.use(ElementPlus, {
	locale
})
/* 3、加载axios */
app.use(VueAxios, axios)
/* 4、加载路由 */
app.use(router)
/* 4、加载vuex */
app.use(store)
/* 最后、挂载元素 */
app.mount('#app')
