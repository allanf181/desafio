(ns cc.logic
  (:require [cc.util :as ut]
            [cc.schema :as xs]
            [schema.core :as s]))
(s/set-fn-validation! true)

(defn get-compras [compras cliente cartao]
  ((compras (keyword (cliente :cpf))) (keyword (cartao :numero))))

(defn agrupar-compras-por-categoria [compras]
  (vec (map
         (fn [[k v]]
           {:categoria k
            :total     (reduce + (map :valor v))})
         (group-by :categoria compras))))

(defn agrupar-compras-por-mes [compras]
  (vec (map
         (fn [[k v]]
           {:mes   k
            :valor (reduce + (map :valor v))})
         (group-by ut/get-month-from-compra compras))))

(s/defn adiciona-compra [compras cliente cartao compra :- xs/Compra]
  (update-in compras [(keyword (cliente :cpf)) (keyword (cartao :numero))] conj compra))
