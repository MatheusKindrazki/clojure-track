(ns run-length-encoding
  (:require [clojure.string :refer [join blank?]]))

(def encode
  (comp (partition-by identity)
        (mapcat (juxt count first))
        (remove #{1})))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> (into [] encode plain-text)
    join))

(defn get-num
  [n?]
  (if (blank? n?)
    1
    (read-string n?)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> (re-seq #"(\d*)(\D)" cipher-text)
        (mapcat (fn [[_ n? l]]
            (repeat (get-num n?) l)))
        join))