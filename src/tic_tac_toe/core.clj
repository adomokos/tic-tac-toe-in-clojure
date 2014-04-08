(ns tic-tac-toe.core
  (require [tic-tac-toe.game :refer :all])
  (:gen-class))

(def state (atom :running))

(defn print-next-step [board move]
  (println (print-board board))
  (println (str "You moved to: " move)))


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
          (try
            (do
              (swap! game-board record-user-move move)
              (swap! game-board record-computer-move)
              (print-next-step @game-board move))
            (catch IllegalArgumentException e
              (do
                (print-next-step @game-board move)
                (println "Sorry, incorrect move..."))))
          (reset! state :stop))))))
