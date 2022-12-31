package com.solid.solidprinciples.lsp.problem;

public class Instagram extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {
        //not application in this platform
        /**
         * Here we can see Instagram[child] is not substitute of the SocialMedia[parent] class.
         * So we can say this platform not follow the liskov substitution principle.
         * */
    }
}
