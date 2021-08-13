(ns cc.db
   (:require [datomic.api :as d]
             [cc.schema :as s]))

;(def cliente {:nome "Allan Fernando", :cpf "12345678909", :email "allan@allan.com"})
;
;(def cartao {:numero "1111222233334444", :cvv "246", :validade "12/2030", :limite 10000.00M})
;
;(def compras {})
;
;(defn update-compras [compras]
;   (def compras compras))

(def db-uri "datomic:dev://localhost:4334/cartao")

(defn abre-conexao []
   (d/create-database db-uri)
   (d/connect db-uri))

(defn apaga-banco []
   (d/delete-database db-uri))

(defn cria-schema [conn]
   (d/transact conn s/schema))

(defn get-compras [db]
   (d/q '[:find (pull ?compra [*])
          :where [?compra :compra/id]]
        db))