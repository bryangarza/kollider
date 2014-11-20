(ns kollider.pages.home
  (:require [reagent.core :as reagent :refer [atom]]))

(def app-state
  (atom
    {:posts
     [{:user "bryan" :message "This is post 1"}
      {:user "jonh" :message "This is the second post"}
      {:user "jax" :message "My 3rd post"}]}))

(defn update-posts! [f & args]
  (apply swap! app-state update-in [:posts] f args))

(defn add-post! [text]
  (update-posts! conj {:user "bryan" :message text}))

(defn post-status []
  (let [val (atom "")]
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
   [:h2 "Latest"]
   [:ul
    (for [p (:posts @app-state)]
      [show-post p]) ]
   [post-status]])

(defn home-page []
  [post-list])
