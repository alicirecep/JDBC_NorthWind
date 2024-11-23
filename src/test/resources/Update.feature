Feature: UPDATE EXECUTION

  Background:
    * Database baglantisi olusturulur.


  @insert
  Scenario:  Kullanıcı, sisteme yeni bir sipariş eklemek istiyor.

    * Insert sorgusu hazirlanir ve calistirilir.
    * Insert sorgu sonuclari dogrulanir.
    * Database baglantisi sonlandirilir.

@update
  Scenario:  Kullanıcı, mevcut bir siparişin ship_name'i güncellemek istiyor.


    * Update sorgusu hazirlanir ve calistirilir
    * Update sonucu dogrulanir.
    * Database baglantisi sonlandirilir.

@delete
Scenario: Kullanıcı, bir siparişi tamamen sistemden silmek istiyor.

  * Delete sorgusu hazirlanir ve calistirilir
  * Delete sonucu dogrulanir.
  * Database baglantisi sonlandirilir.