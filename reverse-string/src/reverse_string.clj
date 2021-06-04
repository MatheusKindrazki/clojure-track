(ns reverse-string)

(defn reverse-string [string]
  (def str (reverse (clojure.string/split string #"")))
  (clojure.string/join str)
)
