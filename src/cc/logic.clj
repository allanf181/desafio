(ns cc.logic
  (:require [cc.util :as ut]
            [cc.schema :as xs]
            [schema.core :as s]))

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

(defn adiciona-compra [compras cliente cartao compra]
  (s/validate xs/Compra compra)
  (update-in compras [(keyword (cliente :cpf)) (keyword (cartao :numero))] conj compra))
