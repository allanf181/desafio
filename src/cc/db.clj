(ns cc.db (:require cc.util))

(def cliente {:nome "Allan Fernando", :cpf "12345678909", :email "allan@allan.com"})

(def cartao {:numero "1111222233334444", :cvv "246", :validade "12/2030", :limite 10000})

(def compras {:12345678909
              {:1111222233334444
               [{:data (cc.util/date-from 25 7 2021), :valor 79.56, :estabelecimento "Supermercado", :categoria "Alimentação"},
                {:data (cc.util/date-from 12 6 2021), :valor 91.34, :estabelecimento "Supermercado", :categoria "Alimentação"},
                {:data (cc.util/date-from 23 7 2021), :valor 12.09, :estabelecimento "Uber", :categoria "Transporte"},
                {:data (cc.util/date-from 13 6 2021), :valor 6.71, :estabelecimento "Uber", :categoria "Transporte"}]}})


