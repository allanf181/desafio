(ns cc.core-test
  (:require [clojure.test :refer :all]
            [cc.logic :as l]
            [cc.util :as ut]))

(deftest adiciona-compra
  (testing "Lista vazia"
    (is (= {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}]}}
           (l/adiciona-compra {} {:cpf "1"} {:numero "2"} {:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}))))
  (testing "Lista cliente igual"
    (is (= {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}
                    {:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"}]}}
           (l/adiciona-compra {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}]}}
                              {:cpf "1"} {:numero "2"} {:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"}))))
  (testing "Lista cliente diferente"
    (is (= {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}]}
            :3 {:4 [{:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"}]}}
           (l/adiciona-compra {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}]}}
                              {:cpf "3"} {:numero "4"} {:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"})))))

(deftest listar-compras
  (testing "Lista de compras 2 itens"
    (is (= [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}
            {:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"}]
           (l/get-compras {:1 {:2 [{:data (ut/date-from 1 1 2021), :valor 1.23M, :estabelecimento "EST", :categoria "CAT"}
                                   {:data (ut/date-from 2 1 2021), :valor 2.23M, :estabelecimento "EST2", :categoria "CAT2"}]}} {:cpf "1"} {:numero "2"})))))

(deftest listar-compras-categoria
  (testing "Lista de compras 4 itens 2 categorias"
    (is (= [{:categoria "CAT1", :total 3.03M} {:categoria "CAT2", :total 30.03M}]
           (l/agrupar-compras-por-categoria [{:data (ut/date-from 1 1 2021), :valor 1.01M, :estabelecimento "EST", :categoria "CAT1"}
                                             {:data (ut/date-from 1 1 2021), :valor 10.01M, :estabelecimento "EST", :categoria "CAT2"}
                                             {:data (ut/date-from 1 1 2021), :valor 2.02M, :estabelecimento "EST", :categoria "CAT1"}
                                             {:data (ut/date-from 1 1 2021), :valor 20.02M, :estabelecimento "EST", :categoria "CAT2"}])))))

(deftest listar-faturas
  (testing "Lista de compras 4 itens 2 meses"
    (is (= [{:mes "fevereiro/2021", :valor 11.11M} {:mes "janeiro/2021", :valor 22.22M}]
           (l/agrupar-compras-por-mes [{:data (ut/date-from 1 2 2021), :valor 1.01M, :estabelecimento "EST", :categoria "CAT1"}
                                       {:data (ut/date-from 2 2 2021), :valor 10.10M, :estabelecimento "EST", :categoria "CAT2"}
                                       {:data (ut/date-from 1 1 2021), :valor 2.02M, :estabelecimento "EST", :categoria "CAT1"}
                                       {:data (ut/date-from 2 1 2021), :valor 20.20M, :estabelecimento "EST", :categoria "CAT2"}])))))