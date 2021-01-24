const app = new Vue({
  el: '#app',
  data: {
    currentInput: '',
    tasks: [
      {
        taskId: 1,
        taskName: "learn js",
        done: false
      },
      {
        taskId: 2,
        taskName: "study hard",
        done: true
      },
      {
        taskId: 3,
        taskName: "party hard",
        done: false
      },
      {
        taskId: 4,
        taskName: "go to town",
        done: false
      },
    ]
  },
  methods: {
    addToList() {
      const taskToAdd = {
        taskId: this.tasks.lenght,
        taskName: this.currentInput,
        done: false
      }

      this.tasks.push(taskToAdd);
    },
    markAsDone(task) {
      task.done = true;
    }
  },
  computed: {

  }
})