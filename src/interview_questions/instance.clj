(ns interview-questions.instance
    (:gen-class
     :implements [java.util.Iterator]
     :init init
     :constructors {[String] []}
     :state state))

(defn -init [s]
  [[] (ref {:s s :index 0})])

(defn -hasNext [this]
  (let [{:keys [s index]} @(.state this)]
    (< index (count s))))

(defn -next [this]
  (let [{:keys [s index]} @(.state this)
        ch (.charAt s index)]
    (dosync (alter (.state this) assoc :index (inc index)))
    ch))

(gen-interface
 :name interview_questions.IBar
 :methods [[bar [] String]])

(gen-class
 :name interview_questions.impl
 :implements [interview_questions.IBar]
 :prefix "impl-"
 :methods [[foo [] String]])

(defn impl-foo [this]
  (str (class this)))

(defn impl-bar [this]
  (str "I " (if (instance? interview_questions.IBar this)
              "am"
              "am not")
       " an IBar"))

(defn -main [s]
  (let [x (new interview_questions.instance s)
        y (new interview_questions.impl)]
    (while (.hasNext x)
      (println (.next x)))
    (println (.foo y))
    (println (.bar y))))
