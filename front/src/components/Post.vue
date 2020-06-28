<template>
    <div class="post_box" v-on:click="onClick">
        <img src="https://i.pinimg.com/originals/91/2d/17/912d179774c45272f6caf83bdf03e6ca.jpg"/>
        <div class="post_body">
            <div class="post_header">{{title}}</div>
            <div class="post_content_short">{{content}}</div>
            <div class="post_other_content">2020.06.03</div>
        </div>
        <div class="post_footer">
            <div>
                <div class="post_writer">{{user.userName}}</div>
            </div>
            <div>
                <i class="fas fa-heart"></i>
                <span class="like_number">36</span>
            </div>

        </div>
    </div>
</template>
<script>
export default {
    props:{
        title: String,
        content: String,
        user: Object,
        id: Number
    },
    methods: {
        onClick(){
            this.$router.push(`/post/edit/${this.id}`);
        }
    },
}
</script>
<style>
</style>