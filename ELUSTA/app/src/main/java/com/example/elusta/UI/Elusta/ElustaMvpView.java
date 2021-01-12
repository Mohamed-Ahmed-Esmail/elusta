package com.example.elusta.UI.Elusta;

import com.example.elusta.Model.ServicesPojoModel;
import com.example.elusta.UI.base.BaseMvpView;

public interface ElustaMvpView extends BaseMvpView {
    void showData(ServicesPojoModel.DataEntity  servicesPojoModel);
}
