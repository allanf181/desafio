(ns cc.core
  (:require [cc.db]
            [cc.logic]
            [clojure.pprint]))

(println "Running...")

(println "Cliente")
(clojure.pprint/pprint cc.db/cliente)
(println)
(println "Cartão")
(clojure.pprint/pprint cc.db/cartao)
(println)
(println "Compras")
(clojure.pprint/print-table (cc.logic/get-compras cc.db/cliente cc.db/cartao))
(println)
(println "Compras por categoria")
(clojure.pprint/print-table (cc.logic/agrupar-compras-por-categoria (cc.logic/get-compras cc.db/cliente cc.db/cartao)))
(println)
(println "Faturas")
(clojure.pprint/print-table (cc.logic/agrupar-compras-por-mes (cc.logic/get-compras cc.db/cliente cc.db/cartao)))






