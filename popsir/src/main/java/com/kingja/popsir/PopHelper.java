package com.kingja.popsir;

import java.util.Arrays;

/**
 * Description:TODO
 * Create Time:2018/3/21 15:42
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class PopHelper {

    private final BasePop pop;
    private final PopSpinner popSpinner;

    public PopHelper(BasePop pop, PopSpinner popSpinner) {
        this.pop = pop;
        this.popSpinner = popSpinner;
    }

    public static PopHelper createListPopHelper(BasePop pop, PopSpinner popSpinner) {
        return new PopHelper(pop, popSpinner);
    }

    public void setListPopListener() {
        ((ListPop) pop).setOnItemClickListener(new ListPop.OnItemClickListener<String>() {
            @Override
            public void onItemClick(String item, int position) {
                popSpinner.setSelectText(item);
            }
        });

        popSpinner.setOnSpinnerStatusChangedListener(new PopSpinner.OnSpinnerStatusChangedListener() {
            @Override
            public void setOnSpinnerStatusChanged(boolean opened) {
                if (opened) {
                    pop.showAsDropDown(popSpinner);
                } else {
                    pop.dismiss();
                }
            }
        });
    }
}
