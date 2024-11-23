Feature: UPDATE EXECUTION

  @insert
  Scenario:  Kullanıcı, sisteme yeni bir sipariş eklemek istiyor.

    * Database baglantisi olusturulur.
    * Insert sorgusu hazirlanir ve calistirilir.
    * Insert sorgu sonuclari dogrulanir.
    * Database baglantisi sonlandirilir.