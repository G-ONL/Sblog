<template>
<div>
    <div class="total">
        <div class="center_big_column">
            <div class="header">
                <div class="header_column">
                    <img src="https://ifh.cc/g/LnCMoH.jpg" />
                    <span>S-blog</span>
                </div>
                <div class="header_column">
                    <i class="fas fa-search"></i>
                    <button class="new_post" v-on:click="()=>{this.$router.push({name:'CreatePost'})}">새 글 작성</button>
                    <button class="me" v-on:click="toggleSetting">
                        {{this.$store.state.userId}}
                        <span>님</span>
                        <div v-show="this.settingIsVisible == true" class="setting_window">
                            <div>설정</div>
                            <div v-on:click="logout">로그아웃</div>
                        </div>
                    </button>
                </div>
            </div>
            <div v-if="this.$store.state.posts.length == 0">
                <img src="https://ifh.cc/g/LnCMoH.jpg" style="margin-top:200px; margin-right:100px; width:100px; height:100px; border-radius:50%"/>
                <h1 style="position:relative; right:100px; top:40px;">아직 계시물이 없어요!</h1>
            </div>
            <div class="posts_box" v-else>
                <Post v-for="(post, index) in this.$store.state.posts" 
                    :key="index"
                    :title="post.title"
                    :content="post.content"
                    :user="post.user"
                    :id="post.id"></Post>
            </div>
        </div>
    </div>
    <div class="dashboard">
        <div class="header">공지사항</div>
        <div class="body">
            <div class="dash">
                <div class="header">일요일 스터디 장소 변경</div>
                <div class="date">2020년 6월 20일</div>
            </div>
            <div class="dash">
                <div class="header">Vue 원데이 클리닉 참여인원 모집</div>
                <div class="date">2020년 6월 21일</div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import Post from "../components/Post.vue"
export default {
  components:{
      Post
  },
  data:function(){
      return{
          settingIsVisible: false
      }
  },
  methods:{
      toggleSetting(){
          this.settingIsVisible = ! this.settingIsVisible;
      },
      logout(){
          this.$store.dispatch('logout');
      }
  },
  name: "Home",
  created() {
      this.$store.dispatch('getPosts');
  },
};
</script>

<style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #F8F9FA;
        }
        .total {
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: left;
        }

        .header_column * {
            margin: 12px;
        }

        .header_column i {
            font-size: 18px;
        }

        .header_column button {
            border: 1px solid black;
            padding: 6px 15px;
            border-radius: 20px;
            font-weight: 600;
            background-color: white;
        }
        .header_column .me {
            border: none;
            padding: 10px 10px;
            border-radius: 5px;
            font-weight: 600;
            background-color: transparent;
            font-size: 16px;
            width: 5vw;
            height: 5vh;
        }
        .header_column .me:hover{
            background-color: #d7e1f7;
        }
        .header_column .me .setting_window{
            display: relative;
            right: 10vw;    
            width: 10vw;
            height: 10vh;
            z-index: 30;
            background-color: gray;
        }
        .center_big_column {
            width: 85%;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: left;
            align-items: center;
        }

        .center_big_column .header {
            width: 100%;
            height: 12vh;
            display: flex;
            justify-content: center;
            background-color: #F8F9FA;
        }

        .center_big_column .header .header_column {
            width: 50%;
            display: flex;
            align-items: center;
            padding: 1px 0px;
        }

        .center_big_column .header .header_column .new_post:hover {
            background-color: #becae6;
        }

        .center_big_column .header .header_column:nth-child(1) {
            justify-content: flex-start;
        }

        .center_big_column .header .header_column:nth-child(1) img {
            width: 35px;
            height: 35px;
            border-radius: 50%;
        }

        .center_big_column .header .header_column:nth-child(1) span {
            font-weight: 900;
            font-size: 20px;
            color: rgb(63, 63, 119);
        }

        .center_big_column .header .header_column:nth-child(2) {
            justify-content: flex-end;
        }

        .center_big_column .posts_box {
            width: 100%;
            display: grid;
            grid-template-columns: repeat(3, 310px);
            gap: 20px;
            margin-top: 80px;
        }

        .center_big_column .posts_box .post_box {
            width: 290px;
            height: 320px;
            border: 1px solid rgb(247, 247, 247);
            border-radius: 6px;
            background-color: white;
            overflow: hidden;
        }

        .center_big_column .posts_box .post_box:hover{
            background-color: #dfe6f7;
        }

        .center_big_column .posts_box .post_box img {
            width: 100%;
            height: 45%;
            object-fit: cover;
            object-position: center;
        }

        .center_big_column .posts_box .post_box .post_body {
            padding: 16px;
            padding-bottom: 10px;
            border-bottom: 1px solid rgb(235, 235, 235);
        }

        .post_body .post_header {
            font-size: 15px;
            text-align: left;
            font-weight: 700;
        }

        .post_body .post_content_short {
            margin-top: 7px;
            text-align: left;
            font-weight: 300;
            font-size: 12px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            /* 라인수 */
            -webkit-box-orient: vertical;
            word-wrap: break-word;
            line-height: 1.4em;
            max-height: 4.2em;

        }

        .post_body .post_other_content {
            margin-top: 14px;
            text-align: left;
            font-weight: 300;
            font-size: 12px;
            color: #868686;
        }

        .post_footer {
            padding: 13px 14px;
            display: flex;
        }

        .post_footer>div {
            width: 50%;
            display: flex;
            align-items: center;
        }

        .post_footer>div:nth-child(1) {
            justify-content: flex-start;
        }

        .post_footer>div:nth-child(2) {
            justify-content: flex-end;
        }

        .post_footer .post_writer {
            font-size: 10px;
            font-weight: 600;
        }

        .post_footer i {
            font-size: 10px;
            margin-right: 2px;
        }

        .post_footer .like_number {
            font-size: 10px;
        }

        

        @media all and (max-width: 1400px) {
            .dashboard {
                visibility: hidden;
            }
        }

        @media all and (min-width: 1400px) {
            .dashboard {
                
                
                background-color: none;
                width: 13vw;

                position: fixed;    
                right: 10vw;
                top: 20vh;
            }

            .dashboard .header {
                text-align: left;
                padding-bottom: 2vh;
                border-bottom: 1px solid rgb(190, 190, 190);
                font-size: 0.9em;
                font-weight: 600;
            }

            .dash .header {
                font-size: 1em;
                font-weight: 600;
                border: none;
                margin-top: 2vh;
                padding-bottom: 1vh;
            }

            .dashboard .date {
                font-weight: 300;
                font-size: 10px;
                color: gray;
            }
        }
</style>
