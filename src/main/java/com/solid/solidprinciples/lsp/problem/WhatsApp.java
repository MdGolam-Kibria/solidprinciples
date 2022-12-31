package com.solid.solidprinciples.lsp.problem;

public class WhatsApp extends SocialMedia{
    @Override
    public void chatWithFriend() {

    }

    @Override
    public void publishPost(Object post) {
        //not application in this platform
        /**
         * Here we can see WhatsApp[child] is not substitute of the SocialMedia[parent] class.
         * So we can say this platform not follow the liskov substitution principle.
         * */
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupCall(Object... userInfo) {

    }
}
