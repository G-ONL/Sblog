<template>
    <div class="create_post_total">
        <h1>생성하기</h1><br>
        <textarea 
            class="title" 
            placeholder="제목을 입력하세요"
            v-model="title"></textarea>
        <textarea
            class="content"
            placeholder="당신의 이야기를 적어보세요..."
            v-model="content"></textarea>
        <div class="buttons">
            <div class="column">
                <button 
                    class="out"
                    v-on:click="()=>{this.$router.push({name:'Home'})}">나가기</button>
            </div>
            <div class="column">
                <button 
                    class="publishbutton"
                    v-on:click="createPost">Publish</button>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data(){
        return{
            title: '',
            content: ''
        }
    },
    methods: {
        createPost(){
          const { title, content } = this;
          axios.post('http://localhost:8080/api/v1/post',{
              title, content
          },{
              headers:{
                  authorization: localStorage.getItem("token").toString()
              }
          })
          .then(res=>{
              if(res.status==200){
                  this.$router.push({name:"Home"});
              }else{
                  alert("오류가 발생했습니다.");
              }
          })
        }
    }
}

</script>
<style>
        * {
            border: none;
        }

        .create_post_total *:focus {
            border: none;
            outline: none;
        }
        .create_post_total {
            margin-left: auto;
            margin-right: auto;
            margin-top: 10vh;
            height: 80vh;
            width: 30vw;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
        }

        .create_post_total .title {
            font-size: 3em;
            font-weight: 900;
            text-align: left;
            width: 100%;
            word-wrap: break-word;
        }

        .create_post_total .content {
            margin-top: 4vh;
            font-size: 1.5em;
            font-weight: 700;
            width: 100%;
            height: 400px;
        }
        .create_post_total .content::placeholder{
            color: rgb(134, 139, 143);
        }

        .create_post_total .buttons {
            width: 100%;
            display: flex;
            margin-top: 5vh;
        }

        .create_post_total .buttons .column {
            display: flex;
            width: 50%;
        }

        .create_post_total .buttons .column:nth-child(1) {
            justify-content: flex-start;
        }

        .create_post_total .buttons .column:nth-child(2) {
            justify-content: flex-end;
        }

        .create_post_total button{
            width: 50%;
            height: 120%;
            color: white;
            font-weight: 600;
            font-size: 1.2em;
            background-color: #21C997;
            border-radius: 5px;
        }
</style>