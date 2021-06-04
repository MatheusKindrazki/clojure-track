(ns rna-transcription)

(defn single-letter [c]
  (cond
  (= c \A) \U
  (= c \C) \G
  (= c \G) \C
  (= c \T) \A
  )
)

(defn build-string [t]
  {:pre  [(empty? (filter #(nil? %) t))]}
  (apply str t)
  )
(defn to-rna [dna]
  ( let [x (map #(single-letter %) (seq dna)) ]
  (build-string x)
  )
)