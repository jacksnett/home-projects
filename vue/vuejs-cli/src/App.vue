<template>
  <div id="app">
    <h1>let us guess how u feel</h1>
    <div>u feel {{ feelingArray[feeling] }}</div>
    <button @click="increment()">feeling better</button>
  </div>
</template> 

<script>
export default {
  data(){
    return {
      feeling: 0,
      feelingArray: [
        'sad',
        'ok',
        'bourd',
        'fine',
        'good',
        'great',
        'amazing'
      ]
    }
  },
  methods: {
    increment() {
      this.feeling = (this.feeling + 1) % this.feelingArray.length;
    }
  }
}
</script>

<style>
</style>
