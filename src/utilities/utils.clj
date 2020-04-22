(ns utilities.utils
  (:require [clojure.pprint :as pp]
            [clojure.inspector :as insp]
            [clojure.reflect :as reflect])
  (:gen-class))

(def defattrib [:name :flags :parameter-types :return-type])

(defn inspect-obj 
  ([obj] (inspect-obj obj defattrib))
  ([obj attributes]
    (->> 
      (reflect/reflect obj) 
      :members 
      (sort-by :name) 
      (pp/print-table attributes))))


