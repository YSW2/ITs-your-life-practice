import { promises } from 'node:fs';

export class PetRecommender {
  constructor() {
    this.recommendList = [];
  }

  recommendPet(customer) {
    let name = customer.name;
    let recommendPet;

    if (customer.lifestyle === '활동적') {
      recommendPet = '골든 리트리버';
    } else if (customer.lifestyle === '조용한') {
      recommendPet = '고양이';
    }
    this.recommendList.push({ name, recommendPet });
  }
  async saveToFile() {
    await promises.writeFile(
      './pet_recommendations.json',
      `${JSON.stringify(this.recommendList)}`
    );
  }
}
