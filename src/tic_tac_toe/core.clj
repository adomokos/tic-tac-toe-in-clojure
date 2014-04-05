(ns tic-tac-toe.core
  (:gen-class))

(def board
  [[:_ :_ :_][:_ :_ :_][:_ :_ :_]])

(defn print-board [board]
  (let [print-board-line
        (fn [line]
          (apply str (map #(str (name %) " ") line)))]
  (str "\n"
    (apply str (map #(str (print-board-line %) "\n") board)))))

(defn parse-step [step]
  (let [parsed-string (seq step)
        row (first parsed-string)
        col (last parsed-string)
        converted-row (fn []
                        (cond
                          (= row \A) 0
                          (= row \B) 1
                          :else 2))]
    [(converted-row) (-> col str Integer/parseInt dec)]))

(defn record-move [board step mark]
  (let [parsed-step (parse-step step)
        x (first parsed-step)
        y (last parsed-step)]
    (-> board (assoc-in [x y] mark))))

(def state (atom :running))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "You are with X. Where do you want to move?")

  (let [game-board (atom board)]
    (while (= @state :running)
      (let [move (read-line)
            ]
        (if (pos? (count move))
          (do
            (swap! game-board record-move move :X)
            (println (print-board @game-board))
            (println (str "You moved to: " move)))
          (reset! state :stop))))))
