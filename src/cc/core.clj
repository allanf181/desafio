(ns cc.core
  (:use clojure.pprint)
  (:require [cc.db :as db]
            [cc.util :as ut]
            [cc.logic :as l]
            [datomic.api :as d]
            [cc.model :as m]))


(println "Running...")
(println)

(println "Inicializando DB...")
(db/apaga-banco)
(def conn (db/abre-conexao))
(db/cria-schema conn)
(println "DB inicializado")
(println)

(println "Adicionando clientes...")
(let [allan (m/novo-cliente "Allan Fernando" "12345678909" "allan@allan.com")]
     (pprint @(d/transact conn [allan])))
(println "Clientes adicionados")
(println)

(println "Adicionando cartões...")
(let [cartao-allan (m/novo-cartao "1111222233334444" "246" "12/30" 10000.00M "12345678909")]
  (pprint @(d/transact conn [cartao-allan])))
(println "Cartões adicionados")
(println)

(println "Adicionando compras...")
;(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 12 6 2021), :valor 91.34M, :estabelecimento "Supermercado", :categoria "Alimentação"}))
;(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 13 6 2021), :valor 6.71M, :estabelecimento "Uber", :categoria "Transporte"}))
;(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 23 7 2021), :valor 12.09M, :estabelecimento "Uber", :categoria "Transporte"}))
;(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 25 7 2021), :valor 79.56M, :estabelecimento "Supermercado", :categoria "Alimentação"}))
(let [compra1-allan (m/nova-compra (ut/date-from 12 6 2021) 91.34M "Supermercado" "Alimentação" "1111222233334444")]
  (pprint @(d/transact conn [compra1-allan])))
(println "Compras adicionadas")
(println)
;(println "Cliente")
;(pp/pprint db/cliente)
;(println)
;(println "Cartão")
;(pp/pprint db/cartao)
;(println)
(println "Compras")
(print-table (get (db/get-compras (d/db conn)) 0))
(println)
;(println "Compras por categoria")
;(pp/print-table (l/agrupar-compras-por-categoria (l/get-compras db/compras db/cliente db/cartao)))
;(println)
;(println "Faturas")
;(pp/print-table (l/agrupar-compras-por-mes (l/get-compras db/compras db/cliente db/cartao)))
