(ns user
  (:require [clojure.set :refer [union intersection difference]]))

;; Higher Order Functions

;; Map

(map inc [1 2 3])
;;=> (2 3 4)

;; Filter

(filter even? [1 2 3])
;;=> (2)

;; Reduce

(reduce + 0 [1 2 3])
;;=> 6

(reduce
  (fn [r v]
    (conj r v))
  []
  [1 2 3])
;;=> [1 2 3]

;; Sequences

(drop 2 [1 2 3 4 5]) 
;;=> (3 4 5)

(take 5 (cycle [1 2 3 4]))
;;=> (1 2 3 4 1)

(interleave [:a :b :c] [1 2 3])
;;=> (:a 1 :b 2 :c 3)

(partition 2 [1 2 3 4 5 6])
;;=> ((1 2) (3 4) (5 6))

;; Maps and Sets

(def m {:a 1 :b 2 :c 3})

(:b m)
;;=> 2

(m :b)
;;=> 2

(keys m)
;;=> (:a :b :c)

(assoc m :d 4)
;;=> {:a 1 :b 2 :c 3 :d 4}

(union #{:a :b :c} #{:c :d :e})
;;=> #{:a :b :c :d :e}

(intersection #{:a :b :c} #{:c :d :e})
;;=> #{:c}

(difference #{:a :b :c} #{:a})
;;=> #{:b :c}

;; Persistent Data Structures

(let [s1 #{:a :b}
      s2 (disj s1 :a)
      s3 (disj s1 :b)]
  [s2 s3])
;;=> [#{:b} #{:a}]

;; Atoms

(def my-atom (atom [1 2 3]))

@my-atom

(swap! my-atom conj 4)

@my-atom
