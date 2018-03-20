package com.kingja.higo.activity;

import android.widget.ListView;

import com.kingja.contactssir.Contacts;
import com.kingja.contactssir.ContactsLoadTask;
import com.kingja.contactssir.IndexView;
import com.kingja.higo.R;
import com.kingja.higo.adapter.ContactsAdapter;
import com.kingja.higo.base.BaseTitleActivity;
import com.kingja.higo.injector.component.AppComponent;

import java.util.List;

import butterknife.BindView;

/**
 * Description:TODO
 * Create Time:2018/3/14 14:16
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ContactsActivity extends BaseTitleActivity implements ContactsLoadTask.OnContactsLoadListener {
    @BindView(R.id.lv_contacts)
    ListView lvContacts;
    @BindView(R.id.indexView)
    IndexView indexView;

    @Override
    public void initVariable() {

    }

    @Override
    protected void initComponent(AppComponent appComponent) {

    }

    @Override
    protected String getContentTitle() {
        return "通讯录好友";
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_contacts;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ContactsLoadTask contactsLoadTask = new ContactsLoadTask(this, this);
        contactsLoadTask.execute();
    }

    @Override
    protected void initNet() {

    }

    @Override
    public void onLoadStart() {
        setProgressShow(true);
    }

    @Override
    public void onLoadSuccess(List<Contacts> contacts) {
        setProgressShow(false);
        final ContactsAdapter contractsAdapter = new ContactsAdapter(this, contacts);
        lvContacts.setAdapter(contractsAdapter);
        indexView.setOnIndexSelectedListener(new IndexView.OnIndexSelectedListener() {
            @Override
            public void onIndexSelected(int index, String letter) {
                int position = contractsAdapter.getPositionForSection(letter.charAt(0));
                if (position != -1) {
                    lvContacts.setSelection(position);
                }
            }

            @Override
            public void onIndexSelectedCompleted() {
            }
        });
    }
}
