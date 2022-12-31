package com.solid.solidprinciples.lsp.solution;

/**
 * Here we can see WhatsApp[child] is  substitute of the SocialMedia[parent] class.
 * So we can say this platform follow the liskov substitution principle.
 */
public class Instagram extends SocialMedia implements PostMediaManager {
    @Override
    public void publishPost(Object post) {

    }

    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }
}
