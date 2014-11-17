(ns kollider.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(def app-state
  (r/atom
    {:posts
     [{:user "bryan" :message "This is post 1"}
      {:user "jonh" :message "This is the second post"}]}))

(defn update-posts! [f & args]
  (apply swap! app-state update-in [:posts] f args))

(defn add-post! [text]
  (update-posts! conj {:user "bryan" :message text}))

(defn post-status []
  (let [val (r/atom "")]
    (fn []
      [:div
       [:input {:type "text"
                :placeholder "Share something"
                :value @val
                :on-change #(reset! val (-> % .-target .-value))}]
       [:button {:on-click #((add-post! @val)
                             (reset! val ""))}
        "Post"]])))

(defn show-post [p]
  [:li
   (str (get p :user) " - " (get p :message))])

(defn post-list []
  [:div
   [:h1 "Latest"]
   [::ul
    (for [p (:posts @app-state)]
      [show-post p]) ]
   [post-status]])

(defn start []
  (r/render-component
    [post-list]
    (.getElementById js/document "root")))
