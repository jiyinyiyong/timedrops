
ns timedrops.core $ :require
  [] respo-spa.core :refer $ [] render
  [] timedrops.component.container :refer $ [] comp-container

defonce store-ref $ atom 0

defonce states-ref $ atom ({})

defn dispatch $ op op-data

defn render-app ()
  let
      target $ .querySelector js/document |#app
    render (comp-container @store-ref)
      , target dispatch states-ref

defn -main ()
  enable-console-print!
  render-app
  add-watch store-ref :changes render-app
  add-watch states-ref :changes render-app
  println "|app started!"
  if (some? navigator.serviceWorker)
    -> navigator.serviceWorker (.register |./sw.js)
      .then $ fn (registration)
        println |registered: registration.core
      .catch $ fn (error)
        println |failed: error

set! js/window.onload -main

defn on-jsload ()
  render-app
  println "|code updated."