
(ns timedrops.util.time)

(defn pretty-duration [duration]
  (if (< duration 1000)
    (str 0)
    (let [duration-in-s (/ duration 1000)]
      (if (< (.toFixed duration-in-s 1) 60)
        (str (.toFixed duration-in-s 1) "s")
        (let [duration-in-mins (/ duration-in-s 60)]
          (if (< duration-in-mins 60)
            (str (.toFixed duration-in-mins 1) "mins")
            (let [duration-in-hrs (/ duration-in-mins 60)]
              (if (< duration-in-hrs 24)
                (str (.toFixed duration-in-hrs 1) "hrs")
                (let [duration-in-days (/ duration-in-hrs 24)]
                  (if (< duration-in-days 30)
                    (str (.toFixed duration-in-days 1) "days")
                    (let [duration-in-months (/ duration-in-days 30)]
                      (if (< duration-in-months 12)
                        (str (.toFixed duration-in-months 1) "months")
                        (let [duration-in-yrs (/
                                                duration-in-months
                                                12)]
                          (str
                            (.toFixed duration-in-yrs 1)
                            "yrs"))))))))))))))