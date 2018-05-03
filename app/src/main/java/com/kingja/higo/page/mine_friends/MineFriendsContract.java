package com.kingja.higo.page.mine_friends;

import com.kingja.higo.base.BasePresenter;
import com.kingja.higo.base.BaseView;
import com.kingja.higo.model.entiy.Friend;
import com.kingja.higo.model.entiy.Message;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/10/10 14:38
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface MineFriendsContract {
    interface View extends BaseView {
        void onGetMineFriendsSuccess(List<Friend> friends);
    }

    interface Presenter extends BasePresenter<View> {
        void getMineFriends();

    }
}
