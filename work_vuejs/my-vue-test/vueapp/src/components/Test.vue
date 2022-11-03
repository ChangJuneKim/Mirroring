<template>
  <div class="test">
    <h1>{{ title }}</h1>
    <p v-if="showName">{{ user.firstName }}</p>
    <p v-else>Nobody</p>

    <ul>
      <li v-for="item in items" v-bind:key="item.id">{{ item.title }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "test",
  data() {
    return {
      title: "제목",
      user: {
        firstName: "John",
        lastName: "Doe"
      },
      showName: false,
      items: [
        { id: 1, title: "Item One" },
        { id: 2, title: "Item Two" },
        { id: 3, title: "Item Three" },
        { id: 4, title: "Item Four" },
        { id: 5, title: "Item Five" }
      ]
    };
  }
};
</script>

<style scoped></style>
