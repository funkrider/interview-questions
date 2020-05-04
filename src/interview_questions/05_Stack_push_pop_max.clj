(ns interview-questions.05-Stack-push-pop-max
  (:gen-class
   :name interview_questions.05_Stack_push_pop_max
   :init init
   :constructors {[][]}))

(defn -init []
  [[] nil])

;; $ clj
;; => (compile 'interview-questions.05-Stack-push-pop-max)
;; $ java -cp classes:`clj -Spath` interview_questions.05_Stack_push_pop_max


;; Create a stack with push, pop and max functions
;; that all operate in O(1) time.

;; Stack is LIFO - Clojure list gives conj, pop

;; We can use gen-class to create an instance
;; with an internal state.

(gen-class
 :name interview_questions.node
 :init  init
 :constructors {[int int] []}
 :state state
 :prefix "node-"
 :methods [[getValue [] int]
           [getOldMax [] int]])

(defn node-init [v old-max]
  [[] {:value v
       :old-max old-max}])

(defn node-getValue [this]
  (get (.state this) :value))

(defn node-getOldMax [this]
  (get (.state this) :old-max))


(gen-class
 :name interview_questions.demo
 :init  init
 :constructors {[] []}
 :state state
 :prefix "demo-"
 :methods [[push [int] void]
           [pop  [] int]
           [max  [] int]])

(defn demo-init []
  [[] (ref {:q '()
            :q-max Integer/MIN_VALUE})])

(defn demo-push [this v]
  (let [s    @(.state this)
        q     (:q s)
        q-max (:q-max s)
        new-max (max q-max v)
        node (new interview_questions.node v q-max)]

    (dosync (alter (.state this) assoc
                   :q (conj q node)
                   :q-max new-max))))

(defn demo-pop
  [this]
  (let [s @(.state this)
        q (:q s)
        f (peek q)
        p (if (nil? f) nil (.getValue f))
        old-max (if (nil? f)
                  Integer/MIN_VALUE
                  (.getOldMax (first q)))]

    (dosync (alter (.state this) assoc
                   :q (pop q)
                   :q-max old-max))

    p))

(defn demo-max
  [this]
  (:q-max @(.state this)))


(defn -main []
  (let [oDemo (new interview_questions.demo)]
    (.push oDemo 1)
    (.push oDemo 4)
    (.push oDemo 2)
    (.push oDemo 3)

    (println (.max oDemo))

    (.pop oDemo)
    (println (.max oDemo))

    (.pop oDemo)
    (println (.max oDemo))

    (.pop oDemo)
    (println (.max oDemo))

    ))
