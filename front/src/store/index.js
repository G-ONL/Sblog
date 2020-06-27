import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from '../router';
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userId: '',
    isLoggedIn: false,
    posts: [],
  },
  mutations: {
    login: (state, { userId }) => {
      state.userId = userId;
      state.isLoggedIn = true;
    },
    loginFail: (state) => {
      state.token = '';
      state.isLoggedIn = false;
    },
    getPosts: (state, posts) => {
      state.posts = posts;
    }
  },
  actions: {
    login: (context, { userName, password }) => {
      axios
        .post('http://localhost:8080/user/login', { userName, password })
        .then(res => {
          if (res.status == 200) {
            // header에서 authorization 가져오기
            const token = res.headers.authorization;
            // 로컬에 저장(token은 굳이 스토어에 저장하지 않는다. 쿠키에 저장할것이기 때문)
            localStorage.setItem('token', token);
            // memberInfo 가져오기
            context.dispatch('getAndSetMemberInfo');
          }
        })
        .catch(error => {
          console.log(error);
          context.commit('loginFail');
          alert("email, password 확인 해주세요!");
        });
    },
    signin: (context, { userName, password }) => {
      axios.post('http://localhost:8080/user/join', {
        userName, password
      })
        .then(res => {
          if (res.status == 200) {
            router.push("/login");
          } else{
            alert("실패 하였습니다");
          }
        });
    },
    getAndSetMemberInfo: (context) => {
      const token = localStorage.getItem("token").toString();
      axios.post('http://localhost:8080/user/user_info',
        {},
        {
          headers: { authorization: token }
        })
        .then(res => {
          if (res.status == 200){
            const userId = res.data.data;
            context.commit('login', { userId });
            router.push({name:"Home"});
          } else {
            context.commit('loginFail');
          }
        });
    },
    getPosts: (context) => {
      const token = localStorage.getItem("token").toString();
      console.log("token: " + token);
      axios.get('http://localhost:8080/api/v1/posts',
      {
        headers: { authorization: token }
      })
        .then(res=>{
          let posts = res.data.data;
          context.commit('getPosts', posts);
        });
      
    }
  }
});
