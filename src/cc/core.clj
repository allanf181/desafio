(ns cc.core
  (:require [cc.db :as db]
            [cc.util :as ut]
            [cc.logic :as l]
            [clojure.pprint :as pp]))

(println "Running...")
(println)
(println "Adicionando compras...")
(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 12 6 2021), :valor 91.34M, :estabelecimento "Supermercado", :categoria "Alimentação"}))
(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 13 6 2021), :valor 6.71M, :estabelecimento "Uber", :categoria "Transporte"}))
(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 23 7 2021), :valor 12.09M, :estabelecimento "Uber", :categoria "Transporte"}))
(db/update-compras (l/adiciona-compra db/compras db/cliente db/cartao {:data (ut/date-from 25 7 2021), :valor 79.56M, :estabelecimento "Supermercado", :categoria "Alimentação"}))
(println "Compras adicionadas")
(println)
(println "Cliente")
(pp/pprint db/cliente)
(println)
(println "Cartão")
(pp/pprint db/cartao)
(println)
(println "Compras")
(pp/print-table (l/get-compras db/compras db/cliente db/cartao))
(println)
(println "Compras por categoria")
(pp/print-table (l/agrupar-compras-por-categoria (l/get-compras db/compras db/cliente db/cartao)))
(println)
(println "Faturas")
(pp/print-table (l/agrupar-compras-por-mes (l/get-compras db/compras db/cliente db/cartao)))
